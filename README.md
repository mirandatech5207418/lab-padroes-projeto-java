# 🎯 Lab Padrões de Projeto Java

Este projeto demonstra a implementação prática dos três padrões de projeto mais utilizados no desenvolvimento Java: **Singleton**, **Strategy** e **Facade**.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Padrões Implementados](#padrões-implementados)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Exemplos de Uso](#exemplos-de-uso)
- [Tecnologias](#tecnologias)
- [Contribuição](#contribuição)
- [Autor](#autor)

## 📖 Sobre o Projeto

Este laboratório prático foi desenvolvido para demonstrar a aplicação real dos padrões de projeto (Design Patterns) em Java. Cada padrão é implementado com exemplos claros e testes que mostram seu funcionamento na prática.

### 🎯 Objetivos

- ✅ Aprender a implementar padrões de projeto fundamentais
- ✅ Entender quando e como aplicar cada padrão
- ✅ Praticar conceitos de arquitetura de software
- ✅ Desenvolver código mais limpo e organizado

## 🏗️ Padrões Implementados

### 1. 🔐 Singleton
**Propósito:** Garantir que uma classe tenha apenas uma instância e fornecer um ponto global de acesso a ela.

**Implementações:**
- **Lazy:** Instância criada sob demanda
- **Eager:** Instância criada na inicialização da classe
- **LazyHolder:** Thread-safe usando classe interna estática

**Quando usar:**
- Configurações globais da aplicação
- Pools de conexão com banco de dados
- Logs centralizados

### 2. 🎭 Strategy
**Propósito:** Definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.

**Implementação:**
- Interface `Comportamento` com diferentes estratégias
- Classe `Robo` que pode alterar seu comportamento em tempo de execução
- Comportamentos: Normal, Defensivo e Agressivo

**Quando usar:**
- Múltiplas formas de executar uma tarefa
- Algoritmos que podem ser escolhidos dinamicamente
- Evitar condicionais complexas (if/else, switch)

### 3. 🏛️ Facade
**Propósito:** Fornecer uma interface unificada para um conjunto de interfaces de um subsistema.

**Implementação:**
- Subsistema CRM para gravação de clientes
- Subsistema CEP API para consulta de endereços
- Classe `Facade` que simplifica a integração entre os subsistemas

**Quando usar:**
- Simplificar interfaces complexas
- Reduzir dependências entre cliente e subsistemas
- Criar pontos de entrada únicos para funcionalidades

## 📁 Estrutura do Projeto

```
lab-padroes-projeto-java/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── dio/
                └── padroes/
                    └── projeto/
                        ├── Main.java                    # 🚀 Ponto de entrada interativo
                        ├── Test.java                    # 🧪 Testes simples
                        ├── TesteCrmSimples.java         # 🔍 Teste isolado CRM
                        ├── singleton/                   # 🔐 Padrão Singleton
                        │   ├── SingletonLazy.java
                        │   ├── SingletonEager.java
                        │   ├── SingletonLazyHolder.java
                        │   └── TestSingleton.java
                        ├── strategy/                    # 🎭 Padrão Strategy
                        │   ├── Comportamento.java
                        │   ├── ComportamentoNormal.java
                        │   ├── ComportamentoDefensivo.java
                        │   ├── ComportamentoAgressivo.java
                        │   ├── Robo.java
                        │   └── TestStrategy.java
                        └── facade/                      # 🏛️ Padrão Facade
                            ├── Facade.java
                            ├── TestFacade.java
                            ├── subsistema1/
                            │   └── crm/
                            │       └── CrmService.java
                            └── subsistema2/
                                └── cep/
                                    └── CepApi.java
```

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- ☕ **Java 11+** - [Download aqui](https://www.oracle.com/java/technologies/javase-downloads.html)
- 📦 **Maven 3.6+** - [Download aqui](https://maven.apache.org/download.cgi)
- 💻 **IDE de sua preferência** (IntelliJ IDEA, Eclipse, VS Code)

### Verificar instalação:

```bash
java -version
mvn -version
```

## 🚀 Como Executar

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/lab-padroes-projeto-java.git
cd lab-padroes-projeto-java
```

### 2. Compile o projeto

```bash
mvn clean compile
```

### 3. Execute os testes

**Opção 1: Menu Interativo (Recomendado)**
```bash
mvn exec:java -Dexec.mainClass="dio.padroes.projeto.Main"
```

**Opção 2: Todos os padrões de uma vez**
```bash
mvn exec:java -Dexec.mainClass="dio.padroes.projeto.Test"
```

**Opção 3: Testes individuais**
```bash
# Singleton
mvn exec:java -Dexec.mainClass="dio.padroes.projeto.singleton.TestSingleton"

# Strategy  
mvn exec:java -Dexec.mainClass="dio.padroes.projeto.strategy.TestStrategy"

# Facade
mvn exec:java -Dexec.mainClass="dio.padroes.projeto.facade.TestFacade"
```

### 4. Executar sem Maven (alternativo)

```bash
# Compilar
javac -d target/classes src/main/java/dio/padroes/projeto/**/*.java

# Executar
java -cp target/classes dio.padroes.projeto.Main
```

## 🎮 Exemplos de Uso

### 💡 Exemplo Singleton

```java
// Lazy - Criação sob demanda
SingletonLazy instance1 = SingletonLazy.getInstancia();
SingletonLazy instance2 = SingletonLazy.getInstancia();

System.out.println(instance1 == instance2); // true - mesma instância!
```

### 💡 Exemplo Strategy

```java
// Criar o robô
Robo robo = new Robo();

// Alterar comportamento dinamicamente
robo.setComportamento(new ComportamentoNormal());
robo.mover(); // "Movendo-se normalmente..."

robo.setComportamento(new ComportamentoAgressivo());
robo.mover(); // "Movendo-se agressivamente..."
```

### 💡 Exemplo Facade

```java
// Sem Facade: código complexo
String cidade = CepApi.getInstancia().recuperarCidade("12345678");
String estado = CepApi.getInstancia().recuperarEstado("12345678");
CrmService.gravarCliente("João", "12345678", cidade, estado);

// Com Facade: uma linha resolve tudo!
Facade facade = new Facade();
facade.migrarCliente("João Silva", "12345678");
```

## 🛠️ Tecnologias

- **Java 11+** - Linguagem de programação
- **Maven** - Gerenciamento de dependências e build
- **JUnit** - Testes unitários (futura implementação)

## 📚 Conceitos Abordados

- ✅ Design Patterns (Padrões de Projeto)
- ✅ SOLID Principles
- ✅ Clean Code
- ✅ Arquitetura de Software
- ✅ Modularização de código
- ✅ Encapsulamento
- ✅ Polimorfismo
- ✅ Interfaces e Abstrações



---

## 🏷️ Tags

`java` `design-patterns` `singleton` `strategy` `facade` `maven` `clean-code` `solid` `architecture` `programming`
