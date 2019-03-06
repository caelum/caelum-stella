# Caelum Stella

Alguns processos são comuns e recorrentes em sistemas voltados para o público brasileiro. O Stella vai te auxiliar nesse caso, oferecendo uma API simples para validação e formatação de CPF, CNPJ e outros cadastros comuns no Brasil. Além de oferecer uma API para trabalhar com boletos, números e integração com JSF, JPA/Hibernate etc.

Um clássico é o pedido de [validação de CPF em Java](https://blog.alura.com.br/validando-cpf-com-java-atraves-do-stella/). Criamos o Caelum Stella também para ensinar as principais validações brasileiras, seja em Java, JavaScript ou outra linguagem, nos nossos [cursos de validação em Java](https://www.alura.com.br/curso-online-java-brasil-lidando-com-datas-numeros-documentos).

### Build status
   * TravisCI:
     * [![Build Status](https://travis-ci.org/caelum/caelum-stella.svg?branch=master)](https://travis-ci.org/caelum/caelum-stella)
   * Apache Jenkins: 
     * Linux: [![Build Status](]()
     * Windows: [![Build Status]()]()

### Requirements

  * Git
  * Maven 3.5 or above
  * Oracle JDK 7 or OpenJDK 7

### Building

Fork este repositório. Vá para a página do projeto forked e clone o mesmo em seu computador via

```git clone link-to-your-forked-repo-here```.

Digite 

```git remote -v``` 

confirmando que **origin** aparece e aponte para o repositório remoto que fez o fork.

Em seguida, digite 

```git remote add upstream https://github.com/caelum/caelum-stella.git```.

Verifique novamente via

```git remote -v```, se certificando que **origin** e **upstream** estejam configurados (este setup lhe dará condições de [realizar uma sincronização com a ramificação principal do projeto](https://help.github.com/en/articles/syncing-a-fork)).

Pronto, use seu IDE ou o maven:
```
$ mvn install
```

### Running

Use o artefato construído, colocando-o no classpath de sua aplicação através do maven ou diretamente
