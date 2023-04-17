package com.inetum.apialumno.service.exception;

/**
 *
 Class ExceptionService (Esta clase permite controlar los errores y/o excepciones)
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
public class ExceptionService extends Exception {

	private static final long serialVersionUID = 6767054164224328330L;

	public ExceptionService() {
		
	}
	public ExceptionService(String message) {
		super(message);
	}

	public ExceptionService(Throwable cause) {
		super(cause);
	}

	public ExceptionService(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionService(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
