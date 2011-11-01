package org.nthdimenzion.ddd.infrastructure.exception;

public final class DisplayableException extends RuntimeException implements IBaseException{
    private final ErrorDetails errorDetails;
    public final static DisplayableException DEFAULT_UI_EXCEPTION = new DisplayableException();

    public DisplayableException() {
        this.errorDetails = ErrorDetails.UI_ERROR_DETAILS;
    }

    public DisplayableException(IBaseException exception) {
        this.errorDetails = exception.getErrorDetails();
    }

    public DisplayableException(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }

    public DisplayableException havingCause(Throwable cause){
        this.errorDetails.setException(cause);
        return this;
    }

    @Override
    public ErrorDetails getErrorDetails() {
        return new ErrorDetails(errorDetails);
    }

    @Override
    public String toString() {
        return errorDetails.toString();
    }
}
