from cmath import e
import random
import time



def quiz_question():
    num1 = random.randint(1,10)
    num2 = random.randint(1,10)
    operator = random.choice(['*','+','-'])

    if operator =='-':
        if num1<num2:
            num1, num2 =num2, num1
        question = f"{num1} - {num2}"
        answer = num1 - num2
    elif operator == '*':
        question = f"{num1} * {num2}"
        answer = num1 * num2
    else:
        question = f"{num1} + {num2}"
        answer = num1 + num2

    return question, answer

def game(nr_questions, time_limit):
    name = input("Enter your name: ")
    print(f"Welcome to the quiz {name}")
    print("You have 30 seconds for this quiz")

    correct_answers = 0
    start_time = time.time()

    for n in range(nr_questions):
        question, correct_answers = quiz_question()
        print("\n" + question)

        start = time.time()
        elapsed = 0

        user = input("Your answer: ")

        elapsed = time.time() - start

        if elapsed > time_limit:
            print("Time is up! Moving on")
            continue

        if user.isdigit() and int(user) == correct_answers:
            print("Correct!")
            correct_answers += 1

        elif user == '':
            print(f"No answer provided. the correct answer was {correct_answers}.")

        else:
            print(f"Wrong! The correct answer was {correct_answers}")

    end_time = time.time()
    elapsed_time = end_time - start_time

    print("\nQuiz Results:")
    print(f"Number of questions attempted: {nr_questions}")
    print(f"Number of correct answers: {correct_answers}")
    print(f"Number of incorrect answers: {nr_questions-correct_answers}")
    print(f"Total time taken: {elapsed_time:2f} seconds")

nr_questions = 6
time_limit = 10

game(nr_questions, time_limit)
