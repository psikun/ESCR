package com.escr.rabbitmq.receiver;

import com.escr.rabbitmq.feign.ReportFeign;
import com.escr.rabbitmq.vo.ReportRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author psikun
 * @description ReportReceiver
 * @date 2023/04/26/ 20:13
 */

@Component
@Slf4j
public class ReportReceiver {

    @Autowired
    ReportFeign reportFeign;

    @RabbitListener(queues = "postReportQueue")
    public void receive(ReportRequestVO request) {
        log.info(request.toString());
        reportFeign.addByClient(request);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
