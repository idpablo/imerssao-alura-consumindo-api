import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoFilmes implements ExtratorConteudo{

    public List<Conteudo> extraiConteudos(String json) throws IllegalAccessException {

        var parser = new JsonParser();

        List<Map<String, String>> listaAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();

        try{
            for (Map<String, String> atributos : listaAtributos) {

                String titulo = atributos.get("fullTitle");
                String rank = atributos.get("rank");
                String urlImage = atributos.get("image")
                        .replaceAll("(@+)(.*).jpg$", "$1.jpg");
                String crew = atributos.get("crew");
                String imDbRating = atributos.get("imDbRating");

                var conteudo = new Conteudo(titulo, rank, urlImage, crew, imDbRating);

                conteudos.add(conteudo);
            }
        }catch(Exception exc){
            System.out.println("Arquivo não encontrado");
            exc.printStackTrace();
        }
        return conteudos;
    }
}
