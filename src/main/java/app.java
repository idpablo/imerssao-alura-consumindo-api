import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class app {
    public static void main(String[] args) throws Exception {

        //Declaração de metodos
        var http = new ClienteHttp();
        var geradora = new CreateSticker();
        var style = new StyleConsole();

        //Recebendo a URL
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        String json = http.buscaDados(url);

        //Passando a URL para o codigo que fara a extraçaõ da informações
        ExtratorConteudo extrator = new ExtratorConteudoFilmes();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        for(int i = 0; i < 10; i++){

            //Conteudo do JSON filtrado limitado a "i"
            Conteudo conteudo = conteudos.get(i);

            try {
                //Modificando nome da imagem que vai ser salva.
                String nomeArquivo =conteudo.getRank() + " - " + conteudo.getTitulo().replace(":", "-") + ".png";


                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
                geradora.cria(inputStream, nomeArquivo);


                //Pegando conteudo filtrado do arquivo.
                String nomeFilme = conteudo.getTitulo();
                String rank = conteudo.getRank();
                String crew = conteudo.getCrew();
                String imDbRating = conteudo.getImDbRating();
                Double idRating = Double.parseDouble(imDbRating);

                System.out.println(colorize(rank + " - " + nomeFilme, style.getText()));
                System.out.println(colorize("Classificação: "+ idRating, style.getIdRating()));

                if (idRating >= 9.0){
                    System.out.println(colorize("\u2B50 \u2B50 \u2B50 \u2B50 \u2B50", style.getStar()));
                }else{
                    System.out.println(colorize("\u2B50 \u2B50 \u2B50 \u2B50", style.getStar()));
                }

                System.out.println();

                String veriFile = "src\\saida\\" + nomeArquivo;

                boolean file = new File(veriFile).exists();

                if( file == true){

                    System.out.println("Arquivo '" + nomeArquivo + "' foi gerado com sucesso!!");
                }

                System.out.println();

            }catch (FileNotFoundException | MalformedURLException exc) {
                System.out.println("Arquivo não encontrado");
                exc.printStackTrace();
            }
        }
    }
}

