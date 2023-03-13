package br.com.training.WriterArquivoLarguraFixaJob.step;

import br.com.training.WriterArquivoLarguraFixaJob.model.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ArquivoLarguraFixaStepConfig {

    @Bean
    public Step arquivoLarguraFixaStep(JobRepository jobRepository,
                                         PlatformTransactionManager transactionManager,
                                         ItemReader<Cliente> arquivoLarguraFixaReader,
                                         ItemWriter<Cliente> arquivoLarguraFixaWriter) {
        return new StepBuilder("arquivoLarguraFixaStep",jobRepository)
                .<Cliente,Cliente> chunk(1)
                .reader(arquivoLarguraFixaReader)
                .writer(arquivoLarguraFixaWriter)
                .transactionManager(transactionManager)
                .build();
    }

}
