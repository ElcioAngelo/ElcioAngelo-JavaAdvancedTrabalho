package com.example.TrabalhoJava;


import com.example.TrabalhoJava.model.Nota;
import com.example.TrabalhoJava.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;
}
