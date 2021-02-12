package br.com.ricardoianni.desafiodev.service;

@SuppressWarnings("serial")
public class ServiceClientException extends Exception {

	public ServiceClientException() {
	}

	public ServiceClientException(String message) {
		super(message);
	}

	public ServiceClientException(Throwable cause) {
		super(cause);
	}

	public ServiceClientException(String message, Throwable cause) {
		super(message, cause);
	}

}
