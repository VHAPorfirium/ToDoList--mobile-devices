# ToDoList App

Este é um aplicativo Android simples que gerencia uma lista de tarefas. Ele possui:
- Uma tela de abertura (*Splash Screen*) com fundo amarelo (inspirado no amarelo Ferrari) e um ícone centralizado.
- Uma tela de boas vindas.
- Uma tela principal com uma lista de tarefas, permitindo adicionar e remover itens.  

---

## Pré-requisitos
- **Android Studio** instalado (ou outra IDE compatível com Android).  
- **JDK 8+** instalado (a IDE geralmente já cuida disso, mas vale verificar).  
- **Gradle** (gerenciado pelo Android Studio).

---

## Estrutura de Pastas
- **app/src/main/java/com/listadetarefas/**  
  - `MainActivity.java`: Tela principal, responsável por exibir a lista de tarefas.
  - `TelaBoasVindasActivity.java`: Responsavel pelas boas vindas.
  - `AberturaActivity.java`: Tela de abertura (*Splash*).  

- **app/src/main/res/layout/**  
  - `activity_main.xml`: Layout da tela principal.
  - `activity_tela_boas_vindas.xml`: Layout da tela de boas vindas
  - `activity_abertura.xml`: Layout da tela de abertura.  

- **app/src/main/res/drawable/**  
  - `todolistphoto.png` (exemplo): Ícone/imagem para a tela de abertura.  

- **AndroidManifest.xml**: Declarações das Activities e configurações do aplicativo.  

---

## Tecnologias Utilizadas
- **Linguagem**: Java (Android).  
- **Bibliotecas**:  
  - ConstraintLayout (para os layouts).  
  - Classes padrão do Android (AdapterView, ArrayAdapter, etc.).  
- **Ferramentas**:  
  - [Android Studio](https://developer.android.com/studio)  
  - Gradle  
