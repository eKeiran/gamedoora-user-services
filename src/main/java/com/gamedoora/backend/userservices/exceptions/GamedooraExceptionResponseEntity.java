package com.gamedoora.backend.userservices.exceptions;

import lombok.Builder;

/**
 * @author aprajshekhar
 */
@Builder
public class GamedooraExceptionResponseEntity {
  private String status;
  private String message;
  private String details;
}
