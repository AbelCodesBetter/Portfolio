namespace Tutor_Game
    /*
     * Author: Abel Mahlobogoane
     * Date: 14 December 2023
     * Purpose: Creating a tutoring game that will help users improve their spelling
     */
{
    partial class Form1
    {
        
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

    
        private void InitializeComponent()
        {
            this.labelSentence = new System.Windows.Forms.Label();
            this.textBoxInput = new System.Windows.Forms.TextBox();
            this.listBoxAccuracy = new System.Windows.Forms.ListBox();
            this.buttonNewGame = new System.Windows.Forms.Button();
            this.buttonQuit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelSentence
            // 
            this.labelSentence.AutoSize = true;
            this.labelSentence.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSentence.Location = new System.Drawing.Point(18, 14);
            this.labelSentence.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.labelSentence.Name = "labelSentence";
            this.labelSentence.Size = new System.Drawing.Size(151, 29);
            this.labelSentence.TabIndex = 0;
            this.labelSentence.Text = "Hello World";
            // 
            // textBoxInput
            // 
            this.textBoxInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBoxInput.Location = new System.Drawing.Point(24, 66);
            this.textBoxInput.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.textBoxInput.Name = "textBoxInput";
            this.textBoxInput.Size = new System.Drawing.Size(478, 35);
            this.textBoxInput.TabIndex = 1;
            this.textBoxInput.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TextBoxInput_KeyPress);
            // 
            // listBoxAccuracy
            // 
            this.listBoxAccuracy.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBoxAccuracy.FormattingEnabled = true;
            this.listBoxAccuracy.ItemHeight = 25;
            this.listBoxAccuracy.Location = new System.Drawing.Point(24, 137);
            this.listBoxAccuracy.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.listBoxAccuracy.Name = "listBoxAccuracy";
            this.listBoxAccuracy.Size = new System.Drawing.Size(478, 254);
            this.listBoxAccuracy.TabIndex = 2;
            this.listBoxAccuracy.SelectedIndexChanged += new System.EventHandler(this.listBoxAccuracy_SelectedIndexChanged);
            // 
            // buttonNewGame
            // 
            this.buttonNewGame.Location = new System.Drawing.Point(24, 438);
            this.buttonNewGame.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.buttonNewGame.Name = "buttonNewGame";
            this.buttonNewGame.Size = new System.Drawing.Size(180, 46);
            this.buttonNewGame.TabIndex = 3;
            this.buttonNewGame.Text = "New Game";
            this.buttonNewGame.UseVisualStyleBackColor = true;
            this.buttonNewGame.Click += new System.EventHandler(this.buttonNewGame_Click);
            // 
            // buttonQuit
            // 
            this.buttonQuit.Location = new System.Drawing.Point(324, 438);
            this.buttonQuit.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.buttonQuit.Name = "buttonQuit";
            this.buttonQuit.Size = new System.Drawing.Size(180, 46);
            this.buttonQuit.TabIndex = 4;
            this.buttonQuit.Text = "Quit";
            this.buttonQuit.UseVisualStyleBackColor = true;
            this.buttonQuit.Click += new System.EventHandler(this.buttonQuit_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(522, 503);
            this.Controls.Add(this.buttonQuit);
            this.Controls.Add(this.buttonNewGame);
            this.Controls.Add(this.listBoxAccuracy);
            this.Controls.Add(this.textBoxInput);
            this.Controls.Add(this.labelSentence);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "Form1";
            this.Text = "Typing Tutor Game";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelSentence;
        private System.Windows.Forms.TextBox textBoxInput;
        private System.Windows.Forms.ListBox listBoxAccuracy;
        private System.Windows.Forms.Button buttonNewGame;
        private System.Windows.Forms.Button buttonQuit;
    }
}

