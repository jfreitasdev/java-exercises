package PACKAGE_NAME;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep){
        URI endereco = URI.create("https://viacep.com.br/ws/"+cep+"/json/");

        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException("Endereço não encontrado");
        }
    }
}
