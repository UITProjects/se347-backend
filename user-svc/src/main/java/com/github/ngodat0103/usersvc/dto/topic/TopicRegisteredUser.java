package com.github.ngodat0103.usersvc.dto.topic;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicRegisteredUser {

  @NotNull private Instant createdDate;
  @NotNull private Action action;
  private Map<String, Object> additionalProperties;
}
