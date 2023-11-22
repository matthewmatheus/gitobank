package br.com.gitobank.view.interfacesNotificacoes;

public interface EnviarNotificacoesInterface {


    // Método para enviar notificação para um único dispositivo
    void enviarNotificacaoParaDispositivo(String tokenDispositivo, String titulo, String mensagem);

    // Método para enviar notificação para vários dispositivos
    void enviarNotificacaoParaDispositivos(String[] tokensDispositivos, String titulo, String mensagem);

    // Método para enviar notificação para um tópico específico
    void enviarNotificacaoParaTopico(String topico, String titulo, String mensagem);
}

