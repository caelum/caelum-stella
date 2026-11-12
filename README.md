# Caelum Stella

[![Java CI](https://github.com/caelum/caelum-stella/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/caelum/caelum-stella/actions/workflows/ci.yml)

Alguns processos são comuns e recorrentes em sistemas voltados para o público brasileiro. O Stella vai te auxiliar nesse caso, oferecendo uma API simples para validação e formatação de CPF, CNPJ e outros cadastros comuns no Brasil. Além de oferecer uma API para trabalhar com boletos, números e integração com JSF, JPA/Hibernate etc.

Um clássico é o pedido de [validação de CPF em Java](https://blog.alura.com.br/validando-cpf-com-java-atraves-do-stella/). Criamos o Caelum Stella também para ensinar as principais validações brasileiras, seja em Java, JavaScript ou outra linguagem, nos nossos [cursos de validação em Java](https://www.alura.com.br/curso-online-java-brasil-lidando-com-datas-numeros-documentos).

## Requisitos para compilar

- Git.
- JDK 11, versão utilizada pelo CI do projeto. Configure `JAVA_HOME` para o diretório do JDK.
- Apache Maven 3.9.x, disponível no `PATH`.

Confira o ambiente antes de começar:

```sh
java -version
mvn -version
```

O `mvn -version` também informa o JDK utilizado pelo Maven; confira se ele é o JDK 11. A primeira execução do build precisa de acesso à internet para baixar os plugins e as dependências.

## Compilando e executando os testes

Clone o projeto e execute o mesmo comando utilizado pelo CI:

```sh
git clone https://github.com/caelum/caelum-stella.git
cd caelum-stella
mvn -B install --file pom.xml
```

Execute o Maven na raiz do repositório. Ele compila os módulos e exemplos habilitados no `pom.xml`, executa os testes unitários, empacota os artefatos e os instala no repositório Maven local. Os arquivos gerados ficam no diretório `target` de cada módulo. Alguns módulos e exemplos não fazem parte do build padrão; confira a seção `modules` do POM raiz.

Para executar somente os testes unitários do módulo core durante o desenvolvimento:

```sh
mvn -B -pl stella-core test
```

Antes de enviar uma contribuição, execute novamente o build completo. O build padrão não inclui os testes do perfil `integration`. Compilar e testar localmente não exige credenciais de publicação.

## Usando o Stella

O Stella é uma biblioteca: use os artefatos em sua aplicação. Por exemplo, para validar CPF, adicione ao `pom.xml` da aplicação:

```xml
<dependency>
    <groupId>br.com.caelum.stella</groupId>
    <artifactId>caelum-stella-core</artifactId>
    <version>2.2.2</version>
</dependency>
```

Esse exemplo usa uma versão publicada no Maven Central. Para testar alterações locais após o `mvn install`, use a versão de desenvolvimento declarada no POM raiz, atualmente `2.2.3-SNAPSHOT`.

Depois de compilar o projeto, você também pode experimentar a biblioteca com o JShell do JDK 11, a partir da raiz do repositório:

```sh
jshell --class-path stella-core/target/caelum-stella-core-2.2.3-SNAPSHOT.jar
```

No JShell, execute:

```java
import br.com.caelum.stella.validation.CPFValidator;

new CPFValidator().assertValid("11144477735");
System.out.println("CPF válido");
```

O construtor padrão espera um CPF sem máscara. O exemplo usa um valor dos testes do projeto; `assertValid` lança `InvalidStateException` quando o valor é inválido. Digite `/exit` para sair do JShell. Se a versão do projeto mudar, ajuste o nome do JAR no comando.

Para exemplos de geração de boletos, consulte [Gerando Boletos](https://github.com/caelum/caelum-stella/wiki/Gerando-boleto) e os [fontes dos exemplos](examples/boleto-example/src/main/java). Esses fontes não estão incluídos no build padrão.

## Contribuindo

1. Consulte as [issues abertas](https://github.com/caelum/caelum-stella/issues) e os [pull requests](https://github.com/caelum/caelum-stella/pulls) para evitar trabalho duplicado. Para mudanças maiores, alinhe a proposta em uma issue.
2. Faça um [fork do repositório](https://github.com/caelum/caelum-stella/fork) na sua conta e clone o fork, substituindo `SEU_USUARIO` pelo seu usuário do GitHub:

   ```sh
   git clone https://github.com/SEU_USUARIO/caelum-stella.git
   cd caelum-stella
   git remote add upstream https://github.com/caelum/caelum-stella.git
   git remote -v
   ```

   `origin` deve apontar para seu fork e `upstream` para o projeto original.

3. Crie uma branch a partir da versão atual de `upstream/master`:

   ```sh
   git fetch upstream
   git checkout -b minha-contribuicao upstream/master
   ```

4. Faça uma mudança com escopo definido, siga o estilo dos arquivos existentes e inclua testes quando alterar o comportamento da biblioteca. Execute `mvn -B install --file pom.xml` na raiz.
5. Revise o diff com `git diff` e `git diff --check`, adicione somente os arquivos relacionados à mudança e crie seu commit. Envie a branch para o fork:

   ```sh
   git push -u origin minha-contribuicao
   ```

6. Abra um pull request do seu fork para `caelum/caelum-stella`, branch `master`. Descreva o problema, a solução, os comandos de validação executados e seus resultados. Referencie a issue relacionada e informe qualquer limitação de teste.

## Documentação

- [Documentação do projeto](https://github.com/caelum/caelum-stella/wiki).
- [Download e dependências Maven](https://github.com/caelum/caelum-stella/wiki/Download).
