# RemindMe

A simple app that replicates real-world flash cards.

## Project Scope

This app aims to replicate how flash cards work in the real world. Quoting from [Wikipedia](https://en.wikipedia.org/wiki/Flashcard):

> A flashcard or flash card (also known as an index card) is a card bearing information on both sides, which is intended to be used as an aid in memorization. Each flashcard bears a question on one side and an answer on the other

Similar to real world flash cards, RemindMe displays a question, which is selected randomly from a set of questions. The user has the option to see a hint or go to the next question (which will again be randomly selected from the question pool).  If the user chooses to the see the hint, the hint to that question will be displayed and the user will again have the choice to either proceed to the next question or see the solution. Lastly, if the user chooses to see the solution, the relevant solution is displayed along with the option to proceed to the next question.

I wanted to build **RemindMe**, as a **tool to recall my solutions to LeetCode problems**. For this reason, the app describes each question as a ‘problem’. Also, while the text of each problem is lifted from LeetCode, the hints and solutions are mine. (Always happy to update my solutions with more optimal ones. Pull requests are welcome!)  

The app reads a JSON file (`data.txt`) to access the set of problems, solutions and hints. When we want to add a new problem, we will need to update the JSON file.

## Supported Routes

Here are the routes supported by this app:

- `/problem/:id`: This route loads the problem corresponding to the `id` path parameter.
- `/next`: This route redirects to a randomly selected `/problem/:id` route
- `/`: Same as `/next`, it redirects to a new problem route
- `/hint/:id`: Generates a JSON payload containing the hint for the respective problem (to be used by client-side JavaScript).
- `:/solution/:id`: Generates a JSON payload containing the hint and solution for the respective problem (to be used by client-side JavaScript).

The primary goal behind building this application was to learn how to build and deploy a project using Clojure. 

## Deployment

The application is deployed here: [remind.otee.dev](https://remind.otee.dev)
