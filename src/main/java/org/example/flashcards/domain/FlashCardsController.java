package org.example.flashcards.domain;

import org.example.flashcards.data.FileService;
import org.example.flashcards.ui.View;
import org.springframework.stereotype.Service;

@Service
public class FlashCardsController {
    private View view;
    private FileService fileService;

}
