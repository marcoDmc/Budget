package com.example.budget.services;


import com.example.budget.enums.ActionType;
import com.example.budget.enums.EntityType;
import com.example.budget.model.History;
import com.example.budget.model.User;
import com.example.budget.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    public void log(User user, String action, String entityType, Long entityId) {
        History history = new History();
        history.setUser(user);
        history.setAction(ActionType.CREATE);
        history.setEntityType(EntityType.ACCOUNT);
        history.setEntityId(entityId);
        historyRepository.save(history);
    }
}
