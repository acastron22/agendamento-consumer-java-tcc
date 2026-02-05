package agendamento.agendamentoconsumer.consumer;


import agendamento.agendamentoconsumer.model.AgendamentoCriadoEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoConsumer {

    @KafkaListener(
            topics = "agendamentos-criados",
            groupId = "agendamento-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void onMessage(AgendamentoCriadoEvent evento) {
        System.out.println("Evento recebido: ");
        System.out.println("ID: " + evento.getEventId());
        System.out.println("Paciente: " + evento.getPaciente().getNome());
        System.out.println("Medico: " + evento.getConsulta().getMedico());

    }
}
