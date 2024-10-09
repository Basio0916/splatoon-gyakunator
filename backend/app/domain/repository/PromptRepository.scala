package domain.repository

import domain.model.Prompt

trait PromptRepository {
    def findAllPrompts(): List[Prompt]
}