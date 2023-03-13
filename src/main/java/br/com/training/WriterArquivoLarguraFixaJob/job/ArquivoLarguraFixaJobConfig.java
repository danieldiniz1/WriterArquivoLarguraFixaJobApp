package br.com.training.WriterArquivoLarguraFixaJob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ArquivoLarguraFixaJobConfig {

    @Bean
    public Job ArquivoLarguraFixaJob(JobRepository jobRepository, Step arquivoLarguraFixaStep) {
        return new JobBuilder("ArquivoLarguraFixaJob",jobRepository)
                .start(arquivoLarguraFixaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
