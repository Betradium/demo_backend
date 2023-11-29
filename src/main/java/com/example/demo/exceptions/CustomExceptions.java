package com.example.demo.exceptions;

public class CustomExceptions extends RuntimeException {
    public CustomExceptions(String message) {
        super(message);
    }

    public static class InvalidCredentialsException extends CustomExceptions {
        public InvalidCredentialsException() {
            super("Invalid credentials");
        }
    }

    public static class MemberExistsException extends CustomExceptions {
        public MemberExistsException() {
            super("Member already exists");
        }
    }

    public static class TopicNotFoundException extends CustomExceptions {
        public TopicNotFoundException() {
            super("Topic not found");
        }
    }

    public static class PostNotFoundException extends CustomExceptions {
        public PostNotFoundException() {
            super("Post not found");
        }
    }

    public static class CommentNotFoundException extends CustomExceptions {
        public CommentNotFoundException() {
            super("Comment not found");
        }
    }

    public static class InvalidTopicException extends CustomExceptions {
        public InvalidTopicException() {
            super("Incorrect or missing Topic fields");
        }
    }

    public static class InvalidPostException extends CustomExceptions {
        public InvalidPostException() {
            super("Incorrect or missing Post fields");
        }
    }

    public static class InvalidCommentException extends CustomExceptions {
        public InvalidCommentException() {
            super("Incorrect or missing Comment fields");
        }
    }

    public static class MemberNotFoundException extends CustomExceptions {
        public MemberNotFoundException() {
            super("Member not found");
        }
    }


    public static class MemberNotAddedException extends CustomExceptions {
        public MemberNotAddedException() {
            super("Member must be added");
        }
    }
}


