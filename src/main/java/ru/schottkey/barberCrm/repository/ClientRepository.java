package ru.schottkey.barberCrm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.schottkey.barberCrm.model.Client;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {
    List<Client> findByIdIn(List<Integer> ids);
    List<Client> findByNameLike(String name);
}
