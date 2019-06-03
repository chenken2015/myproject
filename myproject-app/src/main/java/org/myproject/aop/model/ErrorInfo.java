package org.myproject.aop.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Detailed of Error
 */
@ApiModel(description = "Detailed of Error")
public class ErrorInfo   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("severitylevel")
  private String severitylevel = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("moreInfo")
  private String moreInfo = null;

  public ErrorInfo code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Error Code
   * @return code
  **/
  @ApiModelProperty(example = "S001", required = true, value = "Error Code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorInfo message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error Message
   * @return message
  **/
  @ApiModelProperty(example = "Error occurs when API interface is processed.", required = true, value = "Error Message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorInfo severitylevel(String severitylevel) {
    this.severitylevel = severitylevel;
    return this;
  }

  /**
   * SeverityLevel Code (\"ERROR\", \"WARNING\", \"INFO\")
   * @return severitylevel
  **/
  @ApiModelProperty(example = "Error", required = true, value = "SeverityLevel Code (\"ERROR\", \"WARNING\", \"INFO\")")
  public String getSeveritylevel() {
    return severitylevel;
  }

  public void setSeveritylevel(String severitylevel) {
    this.severitylevel = severitylevel;
  }

  public ErrorInfo description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the problem with hints about how to fix it
   * @return description
  **/
  @ApiModelProperty(example = "Error occurs when API interface is processed.", required = true, value = "Description of the problem with hints about how to fix it")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ErrorInfo moreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
    return this;
  }

  /**
   * More information on the problem and solution. Or, the error message from backend.
   * @return moreInfo
  **/
  @ApiModelProperty(example = "Error occurs when API interface is processed.", required = true, value = "More information on the problem and solution. Or, the error message from backend.")
  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorInfo errorInfo = (ErrorInfo) o;
    return Objects.equals(this.code, errorInfo.code) &&
        Objects.equals(this.message, errorInfo.message) &&
        Objects.equals(this.severitylevel, errorInfo.severitylevel) &&
        Objects.equals(this.description, errorInfo.description) &&
        Objects.equals(this.moreInfo, errorInfo.moreInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, severitylevel, description, moreInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorInfo {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    severitylevel: ").append(toIndentedString(severitylevel)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

