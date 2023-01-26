package com.github.azharjk.joane.utils;

public class JoaneResponse<ErrorType, DataType> {
  private ErrorType error;
  private DataType data;

  public JoaneResponse(ErrorType error, DataType data) {
    this.error = error;
    this.data = data;
  }

  public ErrorType getError() {
    return error;
  }

  public void setError(ErrorType error) {
    this.error = error;
  }

  public DataType getData() {
    return data;
  }

  public void setData(DataType data) {
    this.data = data;
  }
}
