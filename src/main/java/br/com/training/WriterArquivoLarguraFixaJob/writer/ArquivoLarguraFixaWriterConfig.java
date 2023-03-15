package br.com.training.WriterArquivoLarguraFixaJob.writer;

import br.com.training.WriterArquivoLarguraFixaJob.model.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

@Configuration
public class ArquivoLarguraFixaWriterConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public FlatFileItemWriter<Cliente> arquivoLarguraFixaWriterFormatadoArquivoExterno(){
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("arquivoLarguraFixaWriterFormatadoArquivoExterno")
                .resource(new PathResource("files/Clientes-Saida-Cabecalho.txt"))
                .lineAggregator(lineAggregator())
                .build();
    }

    private LineAggregator<Cliente> lineAggregator() {
        return new LineAggregator<Cliente>() {
            @Override
            public String aggregate(Cliente cliente) {
                String cabecalho = "este é o cabeçalho do arquivo";


                String formato = String.format("[%d] %s - %s\n",Integer.getInteger(cliente.getIdade()),cliente.getNome(),cliente.getSobrenome());

                return cabecalho + formato;
            }
        };
    }
}
