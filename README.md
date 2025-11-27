# 🍺 Locadora Bar - Simulação de Sistema

Este projeto é um sistema de simulação de bar desenvolvido para a disciplina de **Análise e Projeto de Sistemas**. O objetivo é aplicar Padrões de Projeto (Design Patterns) e boas práticas de qualidade de código.

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

1.  **Java JDK 17+**: [Download aqui](https://adoptium.net/) (Usando versao 24 aqui!).
2.  **VS Code**: [Download aqui](https://code.visualstudio.com/).
3.  **Extensão "Extension Pack for Java"**: Instale direto no VS Code.
4.  **Apache Maven**: [Download aqui](https://maven.apache.org/download.cgi).
    * *Importante:* Adicione a pasta `bin` do Maven às Variáveis de Ambiente (PATH) do Windows.

---

## 🚀 Como Configurar o Ambiente (Passo a Passo)

### 1. Clonar o Repositório
Abra o terminal (Git Bash ou CMD) e rode:
```bash
git clone https://github.com/Ivnmendes/trab-final-analise-projeto-sistemas.git
```

### 2. Rodar o App.java
    
#### 2.1 Rode mvn package dentro da pasta locadora-bar:
```bash 
cd trab-final-analise-projeto-sistemas/locadora-bar
mvn package
```

#### 2.2 Rode o App.java:
```bash 
mvn exec:java -Dexec.mainClass="com.anaproj.bar.App"
//ou clique com o botao direito no arquivo App.java e selecione "Run Java"
```