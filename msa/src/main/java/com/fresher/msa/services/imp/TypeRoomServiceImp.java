package com.fresher.msa.services.imp;

import com.fresher.msa.entities.TypeRoom;
import com.fresher.msa.repo.TypeRoomRepository;
import com.fresher.msa.services.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRoomServiceImp implements TypeRoomService {
    @Autowired
    TypeRoomRepository typeRoomRepository;
    @Override
    public List<TypeRoom> getAllTypeRoom() {
        return typeRoomRepository.findAll();
    }

    @Override
    public TypeRoom createTypeRoom(TypeRoom typeRoom) {
        typeRoomRepository.save(typeRoom);
        return typeRoom;
    }
}
