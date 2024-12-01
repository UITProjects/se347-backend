package com.github.ngodat0103.usersvc.config.minio;

import io.minio.MinioClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoconfiguration {

  @Bean
  public MinioClient minioClient(MinioProperties minioProperties) {
    return MinioClient.builder()
        .endpoint(minioProperties.getEndpoint())
        .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
        .build();
  }
}
