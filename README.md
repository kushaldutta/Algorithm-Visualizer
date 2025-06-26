# 🎯 Algorithm Visualizer

A beautiful, interactive web-based visualization of sorting algorithms converted from Java Swing to HTML5 Canvas and JavaScript.

## ✨ Features

- **5 Sorting Algorithms**: Bubble Sort, Selection Sort, Quick Sort, Merge Sort, and Insertion Sort
- **Real-time Visualization**: Watch algorithms sort data in real-time with smooth animations
- **Interactive Controls**: Generate new arrays and control animation speed
- **Responsive Design**: Works on desktop and mobile devices
- **Modern UI**: Beautiful gradient design with smooth animations

## 🚀 Quick Start

### Option 1: Local Development
1. Clone or download this repository
2. Open `index.html` in your web browser
3. That's it! No server setup required

### Option 2: Deploy to GitHub Pages (Free)
1. Create a new GitHub repository
2. Upload these files to your repository:
   - `index.html`
   - `script.js`
   - `README.md`
3. Go to Settings → Pages
4. Select "Deploy from a branch" and choose "main"
5. Your site will be available at `https://yourusername.github.io/repositoryname`

### Option 3: Deploy to Netlify (Free)
1. Go to [netlify.com](https://netlify.com) and sign up
2. Drag and drop your project folder to the deploy area
3. Your site will be live instantly with a random URL
4. You can customize the URL in the site settings

### Option 4: Deploy to Vercel (Free)
1. Go to [vercel.com](https://vercel.com) and sign up
2. Connect your GitHub repository
3. Vercel will automatically deploy your site
4. Get a custom domain and automatic deployments

## 🎮 How to Use

1. **Generate New Array**: Click the "🔄 New Array" button to create a new random dataset
2. **Choose Algorithm**: Click any sorting algorithm button to start the visualization
3. **Control Speed**: Use the speed slider to make animations faster or slower
4. **Watch & Learn**: Observe how different algorithms approach the same sorting problem

## 🛠️ Technical Details

### Original Java Implementation
The original project was built using Java Swing with the following structure:
- `QuickSort.java` - Quick sort visualization
- `MergeSort.java` - Merge sort implementation
- `Main.java` - Main application with UI buttons
- Various chart classes for different algorithms

### Web Conversion
Converted to modern web technologies:
- **HTML5 Canvas** for rendering (replaces Java Swing)
- **JavaScript ES6+** for algorithms and logic
- **CSS3** for modern styling and animations
- **Responsive design** for mobile compatibility

### Algorithm Implementations
All algorithms maintain the same logic as the original Java versions:
- **Bubble Sort**: O(n²) - Simple but inefficient
- **Selection Sort**: O(n²) - Finds minimum and swaps
- **Quick Sort**: O(n log n) average - Divide and conquer
- **Merge Sort**: O(n log n) - Stable divide and conquer
- **Insertion Sort**: O(n²) - Builds sorted array incrementally

## 🌟 Enhancements Over Original

- **Better UI**: Modern gradient design with smooth animations
- **Speed Control**: Adjustable animation speed
- **Mobile Friendly**: Responsive design works on all devices
- **No Installation**: Runs in any modern web browser
- **Easy Deployment**: Can be hosted on any web server or CDN

## 📱 Browser Compatibility

- Chrome 60+
- Firefox 55+
- Safari 12+
- Edge 79+

## 🎨 Customization

You can easily customize the visualization:

### Change Colors
Edit the gradient colors in `script.js`:
```javascript
gradient.addColorStop(0, '#ff6b6b'); // Top color
gradient.addColorStop(1, '#ee5a24'); // Bottom color
```

### Adjust Array Size
Change the `arraySize` variable in `script.js`:
```javascript
let arraySize = 250; // Increase for more bars
```

### Modify Animation Speed
Adjust the speed calculation in `updateSpeed()` function.

## 📄 License

This project is open source. Feel free to use, modify, and distribute as you wish.

## 🤝 Contributing

Feel free to submit issues, feature requests, or pull requests to improve the visualizer!

---

**Enjoy visualizing algorithms! 🎯**
