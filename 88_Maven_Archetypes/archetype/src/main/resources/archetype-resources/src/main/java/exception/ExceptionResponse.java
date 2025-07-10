#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}