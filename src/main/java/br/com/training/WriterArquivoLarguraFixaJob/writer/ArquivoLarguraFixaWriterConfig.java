package br.com.training.WriterArquivoLarguraFixaJob.writer;

import br.com.training.WriterArquivoLarguraFixaJob.model.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaWriterConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public ItemWriter<Cliente> arquivoLarguraFixaWriter(){
        return item -> item.forEach(cliente -> LOGGER.info(cliente));
    }
}
