package com.github.ngodat0103.usersvc.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ngodat0103.usersvc.dto.topic.KeyTopic;
import com.github.ngodat0103.usersvc.dto.topic.TopicRegisteredUser;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfiguration {
  @Bean
  public KafkaTemplate<KeyTopic, TopicRegisteredUser> kafkaTemplate(
      ObjectMapper objectMapper, KafkaProperties kafkaProperties) {
    Map<String, Object> props =
        Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    Serializer<TopicRegisteredUser> valueSerializer = new JsonSerializer<>(objectMapper);
    Serializer<KeyTopic> keySerializer = new KeyTopicSerialize();
    ProducerFactory<KeyTopic, TopicRegisteredUser> producerFactory =
        new DefaultKafkaProducerFactory<>(props, keySerializer, valueSerializer);
    return new KafkaTemplate<>(producerFactory);
  }
}
