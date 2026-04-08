terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
}

# Bloco deixa de ser vazio e ganha os detalhes da sua EC2
resource "aws_instance" "sistema_alunos" {
  ami           = "ami-0b6c6ebed2801a5cb" # <--- Cole a SUA ami aqui
  instance_type = "t3.micro"              # <--- Confirme se é t2 ou t3
  
  # Opcional: Adicione uma tag para ficar bonito no console da AWS
  tags = {
    Name = "servidor-sistema-aulas"
  }
}