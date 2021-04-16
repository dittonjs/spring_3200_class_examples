using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Text;
using Xamarin.Forms;

namespace XamarinCounter
{
    class CounterViewModel: INotifyPropertyChanged
    {
        private int count = 0;


        public Command IncrementCommand { get; set; }
        public Command DecrementCommand { get; set; }

        public CounterViewModel() {
            IncrementCommand = new Command(Increment);
            DecrementCommand = new Command(Decrement);
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public int Count {
            get { return count; }
            set { count = value; PropertyChanged?.Invoke(this, new PropertyChangedEventArgs("Count")); }
        }

        void Increment() {
            Count = Count + 1;
        }

        void Decrement() {
            Count = Count - 1;
        }
    }
}
