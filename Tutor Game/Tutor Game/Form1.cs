using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace Tutor_Game
/*
* Author: Abel Mahlobogoane
* Date: 14 December 2023
* Purpose: Creating a tutoring game that will help users improve their spelling
*/
{
    public partial class Form1 : Form
    {
        // Array of sentences for the game
        private string[] sentences = { "Hello World", "Typing", "C# Programming", "Visual Studio", "Coding", "Eduvos" };

        // Random number generator for selecting sentences
        private Random random = new Random();

        // Current sentence being displayed
        private string currentSentence;

        // Index of the current sentence in the array
        private int currentIndex;

        // List to store correctly typed letters
        private List<char> correctLetters = new List<char>();

        // Dictionary to store accuracy information for each letter
        private Dictionary<char, int> accuracyTable = new Dictionary<char, int>();

        // Form constructor
        public Form1()
        {
            InitializeComponent();
        }

        // Event handler for the form load event
        private void Form1_Load(object sender, EventArgs e)
        {
            // Initialize and start a new game when the form loads
            StartNewGame();
        }

        // Method to start a new game
        private void StartNewGame()
        {
            try
            {
                // Select a random sentence and initialize game variables
                currentIndex = random.Next(sentences.Length);
                currentSentence = sentences[currentIndex];
                DisplaySentence();
                correctLetters.Clear();
                accuracyTable.Clear();
                UpdateAccuracyListBox();
                textBoxInput.Text = string.Empty;
            }
            catch (Exception ex)
            {
                HandleError("Error starting a new game", ex);
            }
        }

        // Method to display the current sentence
        private void DisplaySentence()
        {
            labelSentence.Text = currentSentence;
        }

        // Method to update the accuracy information in the ListBox
        private void UpdateAccuracyListBox()
        {
            listBoxAccuracy.Items.Clear();
            try
            {
                // Iterate through each letter in the current sentence
                foreach (char letter in currentSentence)
                {
                    // Get accuracy information and add it to the ListBox
                    int totalAttempts = accuracyTable.ContainsKey(letter) ? accuracyTable[letter] : 0;
                    int successes = correctLetters.Count(c => c == letter);
                    listBoxAccuracy.Items.Add($"{letter}: {successes}/{totalAttempts}");
                }
            }
            catch (Exception ex)
            {
                HandleError("Error updating accuracy list box", ex);
            }
        }

        // Event handler for key press in the input TextBox
        private void TextBoxInput_KeyPress(object sender, KeyPressEventArgs e)
        {
            try
            {
                // Check if Enter key is pressed to evaluate accuracy
                if (e.KeyChar == (char)Keys.Return)
                {
                    CheckAccuracy();
                    textBoxInput.Text = string.Empty;
                    DisplaySentence();
                }
                else
                {
                    // Record accuracy for each key press
                    RecordAccuracy(e.KeyChar);
                }
            }
            catch (Exception ex)
            {
                HandleError("Error processing key press", ex);
            }
        }

        // Method to check the accuracy of the input
        private void CheckAccuracy()
        {
            bool perfectScore = true;

            try
            {
                // Sets to keep track of processed and remaining letters
                HashSet<char> processedLetters = new HashSet<char>();
                HashSet<char> remainingLetters = new HashSet<char>(currentSentence);

                // Iterate through each letter in the input
                foreach (char letter in textBoxInput.Text)
                {
                    if (!processedLetters.Contains(letter))
                    {
                        // Update accuracy information and check correctness
                        int totalAttempts = accuracyTable.ContainsKey(letter) ? accuracyTable[letter] : 0;
                        int successes = correctLetters.Count(c => c == letter);
                        accuracyTable[letter] = totalAttempts + 1;

                        processedLetters.Add(letter);

                        if (remainingLetters.Contains(letter))
                        {
                            correctLetters.Add(letter);
                            remainingLetters.Remove(letter);
                        }
                        else
                        {
                            perfectScore = false; // Excess letter typed, mark as incorrect
                        }

                        // Check if there is any letter with less than perfect score
                        if (successes < totalAttempts)
                        {
                            perfectScore = false;
                        }
                    }
                }

                // Update accuracy information in the ListBox
                UpdateAccuracyListBox();

                // Check if the user achieved a perfect score
                if (perfectScore && remainingLetters.Count == 0)
                {
                    MessageBox.Show("You win! Perfect score!", "Congratulations", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    StartNewGame();
                }
                else
                {
                    MessageBox.Show("Try again", "Incorrect", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
            }
            catch (Exception ex)
            {
                HandleError("An unexpected error occurred while checking accuracy", ex);
            }
        }

        // Method to record accuracy for a specific letter
        private void RecordAccuracy(char letter)
        {
            try
            {
                if (!accuracyTable.ContainsKey(letter))
                {
                    accuracyTable[letter] = 0;
                }
            }
            catch (Exception ex)
            {
                HandleError("Error recording accuracy", ex);
            }
        }

        // Event handler for the "New Game" button click
        private void buttonNewGame_Click(object sender, EventArgs e)
        {
            StartNewGame();
        }

        // Event handler for the "Quit" button click
        private void buttonQuit_Click(object sender, EventArgs e)
        {
            Close();
        }

        // Event handler for ListBox selection change 
        private void listBoxAccuracy_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        // Method to handle errors and display error messages
        private void HandleError(string message, Exception ex)
        {
            // Handle unexpected errors
            MessageBox.Show($"{message}\n\nDetails: {ex.Message}", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
    }
}
