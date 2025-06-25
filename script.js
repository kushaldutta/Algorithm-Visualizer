// Global variables
let canvas, ctx;
let array = [];
let arraySize = 250;
let animationSpeed = 50;
let isAnimating = false;

// Initialize the application
window.onload = function() {
    canvas = document.getElementById('canvas');
    ctx = canvas.getContext('2d');
    generateNewArray();
    drawArray();
};

// Generate a new random array
function generateNewArray() {
    if (isAnimating) return;
    
    array = [];
    for (let i = 0; i < arraySize; i++) {
        array.push(Math.floor(Math.random() * 960) + 1);
    }
    drawArray();
}

// Draw the array as bars
function drawArray() {
    const width = canvas.width;
    const height = canvas.height;
    const margin = 10;
    const barWidth = (width - 2 * margin) / arraySize;
    
    // Clear canvas
    ctx.clearRect(0, 0, width, height);
    
    // Draw bars
    for (let i = 0; i < array.length; i++) {
        const x = margin + i * barWidth;
        const barHeight = array[i];
        const y = height - barHeight;
        
        // Create gradient for each bar
        const gradient = ctx.createLinearGradient(x, y, x, height);
        gradient.addColorStop(0, '#ff6b6b');
        gradient.addColorStop(1, '#ee5a24');
        
        ctx.fillStyle = gradient;
        ctx.fillRect(x, y, barWidth - 1, barHeight);
        
        // Add subtle border
        ctx.strokeStyle = '#c44569';
        ctx.lineWidth = 0.5;
        ctx.strokeRect(x, y, barWidth - 1, barHeight);
    }
}

// Sleep function for animation delays
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

// Update animation speed
function updateSpeed() {
    const speedSlider = document.getElementById('speed');
    const speedValue = document.getElementById('speedValue');
    animationSpeed = 101 - speedSlider.value; // Invert so higher slider = faster
    speedValue.textContent = animationSpeed + 'ms';
}

// Disable all buttons during animation
function setButtonsDisabled(disabled) {
    const buttons = document.querySelectorAll('.btn');
    buttons.forEach(btn => {
        btn.disabled = disabled;
    });
    isAnimating = disabled;
}

// Bubble Sort
async function startBubbleSort() {
    if (isAnimating) return;
    setButtonsDisabled(true);
    
    const n = array.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                // Swap elements
                [array[j], array[j + 1]] = [array[j + 1], array[j]];
                drawArray();
                await sleep(animationSpeed);
            }
        }
    }
    
    setButtonsDisabled(false);
}

// Selection Sort
async function startSelectionSort() {
    if (isAnimating) return;
    setButtonsDisabled(true);
    
    const n = array.length;
    for (let i = 0; i < n - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < n; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        
        if (minIndex !== i) {
            [array[i], array[minIndex]] = [array[minIndex], array[i]];
            drawArray();
            await sleep(animationSpeed);
        }
    }
    
    setButtonsDisabled(false);
}

// Quick Sort
async function startQuickSort() {
    if (isAnimating) return;
    setButtonsDisabled(true);
    
    await quickSort(0, array.length - 1);
    setButtonsDisabled(false);
}

async function quickSort(low, high) {
    if (low < high) {
        const pi = await partition(low, high);
        await quickSort(low, pi - 1);
        await quickSort(pi + 1, high);
    }
}

async function partition(low, high) {
    const pivot = array[high];
    let i = low - 1;
    
    for (let j = low; j <= high - 1; j++) {
        if (array[j] < pivot) {
            i++;
            [array[i], array[j]] = [array[j], array[i]];
            drawArray();
            await sleep(animationSpeed);
        }
    }
    
    [array[i + 1], array[high]] = [array[high], array[i + 1]];
    drawArray();
    await sleep(animationSpeed);
    
    return i + 1;
}

// Merge Sort
async function startMergeSort() {
    if (isAnimating) return;
    setButtonsDisabled(true);
    
    await mergeSort(0, array.length - 1);
    setButtonsDisabled(false);
}

async function mergeSort(left, right) {
    if (left < right) {
        const mid = Math.floor((left + right) / 2);
        await mergeSort(left, mid);
        await mergeSort(mid + 1, right);
        await merge(left, mid, right);
    }
}

async function merge(left, mid, right) {
    const leftSize = mid - left + 1;
    const rightSize = right - mid;
    
    const leftArray = new Array(leftSize);
    const rightArray = new Array(rightSize);
    
    // Copy data to temp arrays
    for (let i = 0; i < leftSize; i++) {
        leftArray[i] = array[left + i];
    }
    for (let j = 0; j < rightSize; j++) {
        rightArray[j] = array[mid + 1 + j];
    }
    
    // Merge the temp arrays
    let i = 0, j = 0, k = left;
    
    while (i < leftSize && j < rightSize) {
        if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i];
            i++;
        } else {
            array[k] = rightArray[j];
            j++;
        }
        drawArray();
        await sleep(animationSpeed);
        k++;
    }
    
    // Copy remaining elements
    while (i < leftSize) {
        array[k] = leftArray[i];
        drawArray();
        await sleep(animationSpeed);
        i++;
        k++;
    }
    
    while (j < rightSize) {
        array[k] = rightArray[j];
        drawArray();
        await sleep(animationSpeed);
        j++;
        k++;
    }
}

// Insertion Sort
async function startInsertionSort() {
    if (isAnimating) return;
    setButtonsDisabled(true);
    
    const n = array.length;
    for (let i = 1; i < n; i++) {
        const key = array[i];
        let j = i - 1;
        
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
            drawArray();
            await sleep(animationSpeed);
        }
        
        array[j + 1] = key;
        drawArray();
        await sleep(animationSpeed);
    }
    
    setButtonsDisabled(false);
}

// Add some visual effects
function addCompletionEffect() {
    // Add a completion animation
    const originalSpeed = animationSpeed;
    animationSpeed = 10;
    
    setTimeout(() => {
        animationSpeed = originalSpeed;
    }, 1000);
} 