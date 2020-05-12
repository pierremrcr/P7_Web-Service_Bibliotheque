package com.bibliotheque.batch.config;

import com.bibliotheque.batch.batch.MailItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages = "com.bibliotheque")
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MailItemProcessor mailItemProcessor;

    @Bean
    public MailItemProcessor processor(){
        return new MailItemProcessor();
    }


    @Bean
    protected Step processorMail() {
        return stepBuilderFactory
                .get("mailItemProcessor")
                .tasklet(mailItemProcessor)
                .build();
    }

    @Bean
    public Job mailJob() {
        return jobBuilderFactory
                .get("mailJob")
                .incrementer(new RunIdIncrementer())
                .start(processorMail())
                .build();
    }
}
