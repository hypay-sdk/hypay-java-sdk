package com.hypay.pay.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * http请求工具类
 *
 * @author hypay
 */
public class HttpUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

	private static final String HTTP = "http";
	private static final String HTTPS = "https";
	private static final int CONNECT_TIMEOUT = 30 * 1000;
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	private static final int MAX_THREAD_COUNT = 500;

	private static SSLConnectionSocketFactory sslConnectionSocketFactory;
	private static PoolingHttpClientConnectionManager connectionManager;
	private static CloseableHttpClient httpClient;

	static {
		ConnectionConfig connectionConfig = ConnectionConfig.custom()
				.setBufferSize(9120000)
				.build();

		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(CONNECT_TIMEOUT)
				.setConnectTimeout(CONNECT_TIMEOUT)
				.setSocketTimeout(CONNECT_TIMEOUT)
				.build();

		try {
			SSLContext sslContext = SSLContextBuilder.create()
					.loadTrustMaterial(null, new TrustStrategy() {
						@Override
						public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
							return true;
						}
					}).build();
			sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
		} catch (Exception e) {
			throw new AssertionError(e);
		}

		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register(HTTP, new PlainConnectionSocketFactory())
				.register(HTTPS, sslConnectionSocketFactory)
				.build();

		connectionManager = new PoolingHttpClientConnectionManager(registry);
		connectionManager.setMaxTotal(MAX_THREAD_COUNT);

		httpClient = HttpClientBuilder
				.create()
				.setDefaultRequestConfig(requestConfig)
				.setDefaultConnectionConfig(connectionConfig)
				.setConnectionManager(connectionManager)
				.build();
	}

	/**
	 * get请求
	 *
	 * @param httpGet
	 * @return
	 * @throws IOException
	 */
	public static String get(HttpGet httpGet) throws IOException {
		String result = null;
		CloseableHttpResponse response = null;

		try {
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, UTF_8);
			EntityUtils.consume(entity);

			response.close();

			return result;
		} finally {
			if (null != response) {
				response.close();
			}
			httpGet.releaseConnection();
		}
	}

	/**
	 * post请求
	 *
	 * @param httpPost
	 * @return
	 * @throws IOException
	 */
	public static String post(HttpPost httpPost) throws IOException {
		String result = null;
		CloseableHttpResponse response = null;

		try {
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity, UTF_8);
				EntityUtils.consume(entity);

				response.close();
			}
			return result;
		} finally {
			if (null != response) {
				response.close();
			}
			httpPost.releaseConnection();
		}
	}

	@PreDestroy
	public static void close() throws IOException {
		connectionManager.close();
		httpClient.close();
	}
}
