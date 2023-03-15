package br.com.training.WriterArquivoLarguraFixaJob.reader;

import br.com.training.WriterArquivoLarguraFixaJob.model.Cliente;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

@Configuration
public class ArquivoLarguraFixaReaderConfig {

    @Bean
    public FlatFileItemReader<Cliente> arquivoLarguraFixaReader(){
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("arquivoLarguraFixaReader")
                .resource(new PathResource("files/clientes.txt"))
                .delimited()
                .delimiter(",")
                .names(new String[] {"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class)
                .build();
    }
}
