xy-inc
=
##Processo Seletivo - ZUP
###Informações
O sistema foi testado em Linux e Windows, utilizando o servidor Tomcat7, Java, e o Maven como ferramenta de build.

Foi utilizada a versão 7 do Java, e o MongoDB 2.6.5 como base de dados.
Para edição das propriedades do MongoDB, editar o arquivo mongodb.properties em src/main/resources.
A base de dados é criada automaticamente. Não precisa de script de inicialização. Apenas precisa que o servidor do mongo esteja rodando.
Também é preciso que a variável de ambiente $JAVA_HOME esteja apontando para uma instalação de Java 7.

###Execução
Para executar a aplicação, siga os passos a seguir:

1 - Và até o diretório raíz da aplicação e digite "mvn clean install".

2 - Suba o seu servidor de aplicação e faça o deploy do pacote gerado na pasta target.

3 - Assim que o deploy for finalizado, o sistema já pode ser utilizado.

4 - Considerando que o seu servidor usa as configurações de host 'localhost' e porta '8080', as URLs para teste são as seguintes:

- Adicionar POIs (para Lanchonete em x=27 e y=12): POST [http://localhost:8080/xyinc/poi?x=27&y=12&name=Lanchonete](http://localhost:8080/xyinc/poi?x=27&y=12&name=Lanchonete)
- Listagem de todos os POIs cadastrados: GET [http://localhost:8080/xyinc/poi](http://localhost:8080/xyinc/poi)
- Busca de POI's por proximidade (para x=20, y=10 e dMax=10): GET [http://localhost:8080/xyinc/poi/nearest?x=20&y=10&dMax=10](http://localhost:8080/xyinc/poi/nearest?x=20&y=10&dMax=10)
- Popular a base com os dados padrão: POST [http://localhost:8080/xyinc/poi/populate](http://localhost:8080/xyinc/poi/populate)
- Remover todos os POIs cadastrados: DELETE [http://localhost:8080/xyinc/poi](http://localhost:8080/xyinc/poi)

######Observação: [Instruções de instalação do MongoDB](http://docs.mongodb.org/manual/installation/)
