package br.gov.ma.ssp.cbm.csl.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Component;

@Component
public class GeradorJson {

    public static String FILE = "arquivo.json";

    public byte[] criarArquivoJson(String path_root, String json) throws NullPointerException, IOException {

        File file = new File(path_root + FILE);
        apagarArquivoCriadoAnteriormente(file);
        FileOutputStream fout = new FileOutputStream(file);
        apagarArquivoCriadoAnteriormente(new File(path_root + FILE));
        byte bytes[] = json.getBytes();
        fout.write(bytes);
        fout.close();
        return Files.readAllBytes(file.toPath());

        // Writer wr = new OutputStreamWriter(fileOutputStream);
        // BufferedWriter br = new BufferedWriter(wr);
        // br.write(json);
        // br.close();
        // return FileUtils.readFileToByteArray(fileOutputStream);

        // fileOutputStream = new FileOutputStream(file);

        // planilha.write(fileOutputStream);
        // fileOutputStream.flush();
        // fileOutputStream.close();
        // return FileUtils.readFileToByteArray(file);
    }

    public void apagarArquivoCriadoAnteriormente(File file) {
        file.delete();
    }

}
