public class Conteudo {

    private final String titulo;
    private final String rank;
    private final String urlImagem;
    private final String crew;
    private final String imDbRating;
    public Conteudo(String titulo, String rank, String urlImage, String crew, String imDbRating) {
        this.titulo = titulo;
        this.rank = rank;
        this.urlImagem = urlImage;
        this.crew = crew;
        this.imDbRating = imDbRating;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRank() {
        return rank;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getCrew() {
        return crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }
}
