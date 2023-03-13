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
                .fixedLength()
                .columns(new Range[]{new Range(1,10), new Range(11,20),new Range(21,23),new Range(24)})
                .names(new String[] {"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class)
                .build();
    }
}
