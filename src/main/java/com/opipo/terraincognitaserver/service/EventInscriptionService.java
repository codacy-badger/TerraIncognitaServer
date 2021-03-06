package com.opipo.terraincognitaserver.service;

import java.util.Collection;

import com.opipo.terraincognitaserver.dto.EventInscription;
import com.opipo.terraincognitaserver.dto.EventInscriptionId;

public interface EventInscriptionService extends ServiceDTOInterface<EventInscription, EventInscriptionId> {

    Collection<EventInscription> findByEventId(String eventId);

    EventInscription assignCharacter(EventInscriptionId id, String characterName);
}
