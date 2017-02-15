using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO.Ports;
namespace Диплом
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            getAvialablePorts();
        }

        void  getAvialablePorts()
        {
            String[] ports = SerialPort.GetPortNames();
            comboBox1.Items.AddRange(ports);
        }
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                serialPort1.PortName = comboBox1.Text;
                serialPort1.BaudRate = 9600;
                serialPort1.Open();
                progressBar1.Value = 100;
                button2.Enabled = true;
                groupBox1.Enabled = true;
                groupBox2.Enabled = true;
                groupBox3.Enabled = true;
            }
            catch(Exception)
            {
                MessageBox.Show("Ошибка! Выберите COM - порт!");
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            serialPort1.Close();
            progressBar1.Value = 0;
            button2.Enabled = false;
            groupBox1.Enabled = false;
            groupBox2.Enabled = false;
            groupBox3.Enabled = false;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            serialPort1.Write("4");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            serialPort1.Write("3");
        }

        private void button4_Click(object sender, EventArgs e)
        {
            serialPort1.Write("l");
        }

        private void button6_Click(object sender, EventArgs e)
        {
            serialPort1.Write("r");
        }

        private void button7_Click(object sender, EventArgs e)
        {
            serialPort1.Write("s");
        }

        private void button8_Click(object sender, EventArgs e)
        {
            serialPort1.Write("f");
        }

        private void button9_Click(object sender, EventArgs e)
        {
            serialPort1.Write("z");
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

    }
}
