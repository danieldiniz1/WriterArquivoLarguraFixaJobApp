package br.com.training.WriterArquivoLarguraFixaJob.writer;

import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;

@Component
public class ClienteRodape implements FlatFileFooterCallback {
    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.append("Este é o rodapé do arquivo\n");
    }
}
