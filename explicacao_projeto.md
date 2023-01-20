# testeJavaWS

Metodologias utilizadas:
  Java 8.
  Spring Boot.
  Banco de dados PostgreSQL.
  Gson para conversão de arquivos entre DTO e Entidades.
  Swagger para documentação da API.
  Lombok para maior organização dos DTOS e entidades.
  
 para o codigo eu utilizei uma estrutura onde contem os controllers , seguidos da camada de serviço que realizam a lógica do sistema,  passando para a camada do itg onde é realizado a integração com o JPA, que está feito na camada repository. Para cada camada com lógica foi criado uma classe interface e uma de implementação para maior controle do código. Foram utilizadas Classes util para conversão entre objetos com auxilio do Gson, inicialmente seria utilizado o BeanUtils, porem para organização optei pela utilização do gson.
