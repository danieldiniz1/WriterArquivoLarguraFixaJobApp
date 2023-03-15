package br.com.training.WriterArquivoLarguraFixaJob.writer;

import br.com.training.WriterArquivoLarguraFixaJob.model.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

@Configuration
public class ArquivoLarguraFixaWriterConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public FlatFileItemWriter<Cliente> arquivoLarguraFixaWriterFormatadoArquivoExterno(){
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("arquivoLarguraFixaWriter")
                .resource(new PathResource("files/clientes-Saida.txt"))
                .formatted()
                .format("%-9s %-9s %-2s %-19s")
                .names(new String[]{"nome","sobrenome","idade","email"})
                .build();
    }
}
